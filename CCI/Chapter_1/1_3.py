# CCI Chapter 1 Problem 3
# Takes a string input and then replaces all the spaces with %20

# TODO This test doesn't work, do later!!

urlify = input("Give the string you'd like to urlify: ")

new_string = ""
prev = ''
ran = 1

# Perform the first step here, and get rid of front spaces
# Probably smarter to just start at the end of the string Future Implementation Idea
prev = urlify[0]
if urlify[0] == ' ':
    for begin_c in range(1, len(urlify)):
        if urlify[begin_c] == ' ':
            ran = begin_c
        else:
            break

ran = ran + 1

# Loop that replaces spaces and multiple spaces with %20
for c in range(ran, len(urlify)):
    if urlify[c] == ' ':
        new_string += '%20'
    else:
        new_string += urlify[c]

print('Urlified String:' + new_string)