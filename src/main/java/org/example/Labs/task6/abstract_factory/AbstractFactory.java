package org.example.Labs.task6.abstract_factory;

import org.example.Labs.task6.factory_method.Product;

public interface AbstractFactory {
    AbstractProduct createProductA();
    AbstractProduct createProductB();
}
