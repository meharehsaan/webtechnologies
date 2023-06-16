function validate() {
  var fname = document.getElementById("fname").value;
  var lname = document.getElementById("lname").value;
//   var organization = document.getElementById("organization").value;
  var email = document.getElementById("email").value;
//   var wphone = document.getElementById("wphone").value;
//   var hphone = document.getElementById("hphone").value;
//   var cphone = document.getElementById("cphone").value;
//   var fax = document.getElementById("fax").value;
  var address1 = document.getElementById("address1").value;
//   var address2 = document.getElementById("address2").value;
  var city = document.getElementById("city").value;
//   var state = document.getElementById("state").value;
//   var pcode = document.getElementById("pcode").value;
  var country = document.getElementById("country").value;

  if (fname == "") {
    document.getElementById("name").innerHTML = "First name is empty!!";
    return false;
  }
  if (lname == "") {
    document.getElementById("name").innerHTML = "Last name is empty!!";
    return false;
  }

  if (email) {
    let len = email.length;
    let at = email.indexOf("@");
    let dot = email.indexOf(".");

    if (at == -1 || dot == -1 || at > dot || at + 1 == dot) {
      document.getElementById("5").innerHTML = "Email is in incorrect format!!";
    } else {
      if (at > 0 && dot > at + 1 && dot < len) {
        document.getElementById("5").innerHTML = "Email is in correct format!!";
        // alert("Your mail format is correct");
      }
    }
  } else {
    document.getElementById("5").innerHTML = "Please Email field!";
    return false;
  }

  if (address1 == "") {
    document.getElementById("1").innerHTML = "Address is empty!!";
    return false;
  }
  if (city == "") {
    document.getElementById("2").innerHTML = "City name is empty!!";
    return false;
  }
  if (country == "") {
    document.getElementById("3").innerHTML = "Country name is empty!!";
    return false;
  }
}

function letternumber(event) {
  var keychar = event.key;
  //alert(event.key);
  if (".+-0123456789".indexOf(keychar) > -1) return true;
  else return false;
}
