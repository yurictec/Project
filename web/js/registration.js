function checkPw(form) {
    pw1 = form.pw1.value;
    pw2 = form.pw2.value;

    if (pw1 !== pw2) {
        alert("\nВы ввели в поле \"Повторить\" пароль отличный от введенного в поле \"Пароль\".");
        return false;
    } else
        return true;
}

function validate_form( )
{
    valid = true;
    if (document.regForm.pw1.value === "" || document.regForm.pw2.value === "" 
            || document.regForm.pw3.value === "" || document.regForm.pw4.value === "" || document.regForm.pw5.value === "")
    {
        alert("Пожалуйста, заполните все поля.");
        valid = false;
    }
    return valid;
}