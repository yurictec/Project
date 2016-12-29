function validate_form( )
{
    valid = true;
    if (document.loginForm.pass.value === "" || document.loginForm.email.value === "")
    {
        alert("Пожалуйста, заполните все поля.");
        valid = false;
    }
    return valid;
}