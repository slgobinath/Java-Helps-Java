package com.javahelps.tensorflow.moderserver;

import org.tensorflow.SavedModelBundle;
import org.tensorflow.Session;
import org.tensorflow.Tensor;
import org.tensorflow.TensorFlowException;

import java.util.List;

public class ModelServer {

    public static void main(String[] args) {
        try (SavedModelBundle savedModelBundle = SavedModelBundle.load("/tmp/tf_add_model", "serve")) {

            try (Session session = savedModelBundle.session()) {
                Session.Runner runner = session.runner();
                runner.feed("x", Tensor.create(10));
                runner.feed("y", Tensor.create(20));

                List<Tensor<?>> tensors = runner.fetch("ans").run();
                System.out.println("Answer is: " + tensors.get(0).intValue());
            }

        } catch (TensorFlowException ex) {
            ex.printStackTrace();
        }
    }
}
