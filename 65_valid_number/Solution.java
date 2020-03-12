class Solution {
    public boolean isNumber(String s) {
        boolean digit = false;
        boolean plus = false;
        boolean minus = false;
        boolean plusExp = false;
        boolean minusExp = false;
        boolean exp = false;
        boolean expNum = false;
        boolean dot = false;
        boolean blank = false;
        for (int i = 0;i <s.length();i++) {
            switch (s.charAt(i)) {
                case ' ':
                    if (digit || dot || plus || minus || exp) {
                        blank = true;
                    }
                    break;
                case '.':
                    if (blank || exp || dot) {
                        return false;
                    }
                    dot = true;
                    break;
                case '+':
                    if ((dot && !exp) || blank || (digit && !exp) || (expNum && exp) || (plus && !exp) || (exp && plusExp)) {
                        return false;
                    }
                    if (exp) {
                        plusExp = true;
                    } else {
                        plus = true;
                    }
                    break;
                case '-':
                    if ((dot && !exp) || blank || (digit && !exp) || (expNum && exp) || (minus && !exp) || (exp && minusExp)) {
                        return false;
                    }
                    if (exp) {
                        minusExp = true;
                    } else {
                        minus = true;
                    }
                    break;
                case 'e':
                    if (blank || !digit || exp || i + 1 == s.length()) {
                        return false;
                    }
                    exp = true;
                    break;
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                case '0':
                    if (blank) {
                        return false;
                    }
                    if (exp) {
                        expNum = true;
                    }
                    digit = true;
                    break;
                default:
                    return false;

            }
        }
        if (exp) {
            return digit && expNum;
        } else {
            return digit;
        }
    }
}