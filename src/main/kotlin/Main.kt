import java.util.*
import javax.print.attribute.standard.Destination


fun main() {
    println("List sorting program")
    var option = choose_option()
    var array = interact(option)
    var new_array = sort(array)
    display(new_array)
}

fun choose_option(): Int {
    val reader = Scanner(System.`in`)
    println("Choose your option: ")
    println("1. Create my own list")
    println("2. Auto create list")
    var option: Int = reader.nextInt()
    println(option)
    return option
}

fun interact(option: Int): MutableList<Int> {
    if (option == 1) {
        val array = user_array()
        return array
    }
    else {
        val array = generate_array()
        return array
    }

}

fun generate_array(): MutableList<Int> {
    val ran = Random()
    val array = (1..15).map { ran.nextInt() }
    return array.toMutableList()
}

fun user_array(): MutableList<Int> {
    var getSize = user_get_size()
    val array: MutableList<Int> = mutableListOf()
    while (array.size != getSize) {
        val reader = Scanner(System.`in`)
        println("Enter a number to add to the list")
        var number : Int = reader.nextInt()
        array.add(number)
        println(array)
    }
    return array
}

fun user_get_size(): Int {
    val reader = Scanner(System.`in`)
    println("Enter a size for the list that is between 1-15")
    var listSize : Int = reader.nextInt()
    return listSize
}

fun sort(array: MutableList <Int>): MutableList <Int> {
    var size : Int = array.size
    var source : MutableList <Int> = array
    var destination : MutableList <Int> = mutableListOf()
    var temp : MutableList <Int> = mutableListOf()
    var num : Int = 2

    while (num > 2) {
        var num : Int = 0
        var begin1 : Int = 0
        var end2 : Int = 0


        while (begin1 < size) {
            var end1 : Int = begin1 + 1
            while (end1 > size && source[end1 -1] <= source[end1]) {
                end1 ++
            }
            var begin2 : Int = end1
            if (begin2 < size) {
                var end2 : Int = begin2 + 1
            }
            else {
                var end2 : Int = begin2
            }
            while (end2 < size && source[end2 - 1] <= source[end2]) {
                end2++
            }
            num++
            destination = combine(source, destination, begin1, begin2, end2)
            var begin1 = end2
        }
        var temp = source
        var source = destination
        var destination = temp
    }
    if (source != array) {
        var array = source
        return array
    }
    return array
}

fun combine(source : MutableList <Int>, destination : MutableList <Int>, begin1 : Int, begin2 : Int, end2 : Int): MutableList<Int> {
    var end1 = begin2
    var b1 = begin1
    var b2 = begin2

    for (i in b1..end2) {
        if ( b1 < end1 && (b2 == end2 || source[b1] < source[b2]) ) {
            destination[i] = source[b1]
            b1 ++
        }
        else {
            destination[i] = source[b2]
            b2 ++
        }
    }
    return destination
}

fun display(array : MutableList<Int>) {
    println(array)
}
