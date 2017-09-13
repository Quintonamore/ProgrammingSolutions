# CCI Chapter 1 Problem 4
# Pallindrome permutation, checks to see if the two given strings are the same forwards and backwards.

left = input("Input the first string to be tested: ")
right = input("Input the second string to be tested: ")

result = 1

if len(left) == len(right):
    
    right_c = len(right) - 1
    for c in left:
        if c != right[right_c]:
            result = 0
            break

        right_c -= 1

else:
    result = 0


if result:
    print("These two words are palindromes!")
else:
    print("These two words are not palindromes!")