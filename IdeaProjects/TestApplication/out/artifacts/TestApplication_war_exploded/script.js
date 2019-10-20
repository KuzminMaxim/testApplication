//var username =
//var login = "<?login?>";
var login = <?=$ ?>
//var password = document.getElementById('password');
function check() {/*
            if (username < 3) {
                alert('Fill in the "Name" field');
                return false;
            }/*

            if (password < 6) {
                alert('Password cannot be less than 6 characters');
                return false;
            }*/
    if (login.length < 3) {
        alert("login = "+login.value.length);
        alert("loginlen = "+login.length);
        return false;
    }
    else{
        alert('Registration completed');
        return true;
    }
    alert("login = "+login);
    alert("loginlen = "+login.length);

}