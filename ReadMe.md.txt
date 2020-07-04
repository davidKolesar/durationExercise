# DURATION EXERCISE (UPDATED)
=============================

 This project is a method that takes a duration (given as seconds) and formats it into a human-friendly way. The function must accept a non-negative integer. If it is zero, it just returns "now". Otherwise, the duration is expressed as a combination of seconds, minutes, days, weeks, and months.

# Rules
--------


* This will always be formatted as a positive integer and one of the valid units of time
* It is separated by a space. 
* The unit of time is used in plural if the integer is greater than 1
* Oxford Comma is not necessary.
* A more significant units of time will occur before than a least significant one.
* Different components have different unit of times. So there is not repeated units like in 5 seconds and 1 second.
* A component will not appear at all if its value happens to be zero. Hence, 1 minute and 0 seconds is not valid, but it should be just 1 minute.
* A unit of time must be used "as much as possible". It means that the function should not return 61 seconds, but 1 minute and 1 second instead. 



Examples of the correct resulting expressions are as follows: 

* 4 seconds
* 1 month
* 3 days, 2 hours and 3 seconds


# Note -- There is a different approach in this document I thought up halfway through the Kata. It is in the root directory.
