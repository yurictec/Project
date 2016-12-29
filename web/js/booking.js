function validate_form( )
{
    valid = true;
    if (document.bookingForm.idCar.value === "" || document.bookingForm.date.value === "")
    {
        alert("Пожалуйста, заполните все поля.");
        valid = false;
    }
    return valid;
}