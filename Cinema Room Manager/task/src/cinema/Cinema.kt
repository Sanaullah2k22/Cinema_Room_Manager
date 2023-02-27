package cinema

var total_income = 0
var current_income = 0
fun main() {
   var rows = 0
    var seats = 0
 var totalincome = 0


    println("Enter the number of rows:")
    rows =  readLine()!!.toInt()

    println("Enter the number of seats in each row:")
    seats = readLine()!!.toInt()
    val arr = Array(rows) { Array(seats) { 'S' } }
    var option =0
    println()
    do {
        println("1. Show the seats")
        println("2. Buy a ticket")
        println("3. Statistics")
        println("0. Exit")
        option =readLine()!!.toInt()
        when(option){
            1 -> showSeats(rows,seats,arr)
            2 -> buyTicket(rows,seats,arr)
            3 -> statistics(rows,seats,arr)
            0 -> break
        }
    }while (option != 0)



    //showSeats(rows,seats,arr)

}

fun showSeats(rows:Int, seats:Int, arr: Array<Array<Char>>){

    println("Cinema: ")
    print("  ")
    for(i in 1..seats){
        print("$i ")
    }
    println()
    var counter =1
    for (row in arr) {
        print("$counter ")
        for(col in row){
            print("$col ")
        }
        counter++
        println()
    }
}

fun buyTicket(rows:Int, seats:Int, arr: Array<Array<Char>>){
    println()
    println("Enter a row number:")
    var r = readln().toInt()

    println("Enter a seat number in that row:")
    var sn = readln().toInt()
    if(r > rows ){
        println("Wrong input!")
        return
    }
    if(sn > seats ){
        println("Wrong input!")
        return
    }
    var totlaseats = (rows * seats)
    val firsthalf = rows / 2
    val secondhalf =  rows - firsthalf
if(arr[r-1][sn-1] == 'B') {
    println("That ticket has already been purchased!\n")
    buyTicket(rows,seats,arr)
}
    else
    arr[r-1][sn-1] ='B'


    if (totlaseats < 60) {
        println("\nTicket price: $10")
        current_income += 10
        total_income = totlaseats * 10

    }else
    {
        current_income += if(r <= (rows/2)) {
            println("\nTicket price: $10")
            10
        } else{
            println("\nTicket price: $8")
            8
        }
        total_income = (firsthalf * seats * 10) + (secondhalf * seats * 8)

    }

}

fun statistics(rows:Int, seats:Int, arr: Array<Array<Char>>){
    println()
    var counter = 0
    var percentage = 0.0
    var total_tickets = rows * seats
    val firsthalf = rows / 2
    val secondhalf =  rows - firsthalf
    if (total_tickets < 60) {
      //  println("Ticket price: $10")
       // current_income += 10
        total_income = total_tickets * 10

    }else {

        total_income = (firsthalf * seats * 10) + (secondhalf * seats * 8)
    }
    for (row in arr) {

        for(col in row){
           if(col == 'B')
               counter++
        }
    }
    percentage = ((counter.toDouble() * 100.00)/total_tickets.toDouble()).toDouble()
    var formatPercentage = "%.2f".format(percentage)
    println("Number of purchased tickets: $counter")
    println("Percentage: $formatPercentage%")
    println("Current income: $$current_income")
    println("Total income: $$total_income")
    println()
}