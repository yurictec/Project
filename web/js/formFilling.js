function validate_form( )
{
    valid = true;
    if (document.formFil.pw1.value === "" || document.formFil.pw2.value === "" 
            || document.formFil.pw3.value === "" || document.formFil.pw4.value === "" 
            || document.formFil.pw5.value === "")
    {
        alert("Пожалуйста, заполните все поля.");
        valid = false;
    }
    return valid;
}