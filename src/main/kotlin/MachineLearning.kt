package ru.volggtu

import weka.core.converters.ConverterUtils

fun main() {
    val source = ConverterUtils.DataSource("/some/where/data.arff")
    val data = source.dataSet

    if (data.classIndex() == -1) data.setClassIndex(data.numAttributes() - 1
}