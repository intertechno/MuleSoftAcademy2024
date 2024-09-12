*** Settings ***
Documentation     Simple calculation test for a Python file

Library    MathDemo.py


*** Test Cases ***
Test Sum Calculation
    ${a} =    Convert To Integer    10
    ${b} =    Convert To Integer    20

    ${result} =    calculate_sum    ${a}    ${b}
    ${final} =     Convert To String    ${result}

    Should Be Equal    ${final}    30


Test Sum Calculation 2
    ${result} =    calculate_sum    10    20
    Should Be Equal    ${result}    30
