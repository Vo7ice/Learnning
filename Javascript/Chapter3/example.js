var message = "Hi";
message = 100;
console.log(message);

function sayHi() {
    var hello = "some string";
    console.log(typeof message);
    alert(message);

}
// sayHi()

function myFunction() {
    var name = document.getElementById("name").value;
    var message = document.getElementById("pwd").value;
    alert("Hello\n" + name + "\n" + message);
}