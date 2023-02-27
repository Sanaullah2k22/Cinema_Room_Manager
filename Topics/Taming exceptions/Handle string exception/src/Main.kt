fun main() {
    val index = readLine()!!.toInt()
    val word = readLine()!!
    if(index < 0 || index > word.length -1)
   print("There isn't such an element in the given string, please fix the index!")
    else
    print(word[index])
    
}
