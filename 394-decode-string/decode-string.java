class Solution {
    public String decodeString(String s) {

        Stack<Character> StringStack = new Stack<>();
        Stack<Integer> kStack = new Stack<>();

        int num = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
               num = num*10 + (ch - '0');

            } 
            else if(ch == '[')
            {
                kStack.push(num);
                num = 0;
                StringStack.push(ch);
            }
            else {

                if (Character.isLetter(ch)) {
                    StringStack.push(ch);
                    continue;
                }

                if (ch == ']') {
                    StringBuilder newEncoded = new StringBuilder();
                    while (!StringStack.isEmpty() && StringStack.peek() != '[') {
                        newEncoded.append(StringStack.pop());
                    }

                    StringStack.pop(); // remove the '['
                    newEncoded.reverse(); // we popped the cahr in reverse order so make it straight

                    if (!kStack.isEmpty()) {
                        String temp = newEncoded.toString();
                        int k = kStack.pop();
                        for (int i = 0; i < k - 1; i++) {
                            newEncoded.append(temp);
                        }
                    }

                    String newString = newEncoded.toString();

                    for (char newChar : newString.toCharArray()) {
                        StringStack.push(newChar);
                    }
                }

            }
        }

        StringBuilder str = new StringBuilder();

        while (!StringStack.isEmpty()) {
            str.append(StringStack.pop());
        }

        return str.reverse().toString();
    }
}