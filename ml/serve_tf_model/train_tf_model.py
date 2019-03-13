#!/usr/bin/env python3
import tensorflow as tf
from tensorflow.python.saved_model import builder as saved_model_builder
from tensorflow.python.saved_model import signature_constants
from tensorflow.python.saved_model import signature_def_utils
from tensorflow.python.saved_model import tag_constants
from tensorflow.python.saved_model.utils import build_tensor_info

x = tf.placeholder(tf.int32, name='x')
y = tf.placeholder(tf.int32, name='y')

# This is our model
add = tf.add(x, y, name='ans')

with tf.Session() as sess:
    # Pick out the model input and output
    x_tensor = sess.graph.get_tensor_by_name('x:0')
    y_tensor = sess.graph.get_tensor_by_name('y:0')
    ans_tensor = sess.graph.get_tensor_by_name('ans:0')

    x_info = build_tensor_info(x_tensor)
    y_info = build_tensor_info(y_tensor)
    ans_info = build_tensor_info(ans_tensor)

    # Create a signature definition for tfserving
    signature_definition = signature_def_utils.build_signature_def(
        inputs={'x': x_info, 'y': y_info},
        outputs={'ans': ans_info},
        method_name=tf.saved_model.signature_constants.PREDICT_METHOD_NAME)

    builder = saved_model_builder.SavedModelBuilder('/tmp/tf_add_model')

    builder.add_meta_graph_and_variables(
        sess, [tag_constants.SERVING],
        signature_def_map={
            signature_constants.DEFAULT_SERVING_SIGNATURE_DEF_KEY:
                signature_definition
        })

    # Save the model so we can serve it with a model server :)
    builder.save()
