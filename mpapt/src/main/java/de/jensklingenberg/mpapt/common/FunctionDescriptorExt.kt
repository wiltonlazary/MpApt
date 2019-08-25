package de.jensklingenberg.mpapt.common

import de.jensklingenberg.mpapt.model.FunctionParameter
import org.jetbrains.kotlin.descriptors.FunctionDescriptor


/**
 * TODO: i dont know how to get the packageName of a function parameter
 */
fun FunctionDescriptor.getFunctionParameters(): List<FunctionParameter> {
    //@de.ktorfit.POST public abstract suspend fun postPictures(helloWorld: sample.model.HelloWorld): kotlin.Unit defined in sample.data.Api[SimpleFunctionDescriptorImpl@470930f5]

    return if (valueParameters.isNotEmpty()) {
        val list = this.toString().replace(" ", "").substringAfter("(").substringBefore(")").split(",")
                .map {
                    val split = it.split(":")
                    FunctionParameter(
                            split.first(),
                            de.jensklingenberg.mpapt.model.Package(split[1].substringAfterLast("."), split[1].substringBeforeLast("."))
                    )
                }
        list
    } else {
        emptyList()
    }


}

/**
 * I dont know how to get full package of the return type
 */
fun FunctionDescriptor.getReturnTypeImport(): String = this.toString().substringAfter("): ").substringBefore(" defined")

fun FunctionDescriptor.simpleName(): String = this.name.asString()
