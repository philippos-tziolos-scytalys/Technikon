package com.scytalys.technikon.encryption;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class PasswordEncryption {

    public static String getHashCode(String aCode) {
        char[] code = aCode.toCharArray();
        StringBuffer hashCode = new StringBuffer();

        for (char digit : code) {
            hashCode.append(digit * 97 + Character.getNumericValue('z'));
        }

        char[] newCode = hashCode.toString().toCharArray();
        StringBuffer newHashCode = new StringBuffer();

        Random random = new Random(newCode[1] + newCode[2] + newCode[3] + newCode[4]);

        List<Integer> charSet = new ArrayList<>();

        charSet.addAll(Arrays.asList(33, 35, 36, 37, 38, 64));
        charSet.addAll(IntStream.rangeClosed(48, 57).boxed().toList());
        charSet.addAll(IntStream.rangeClosed(65, 90).boxed().toList());
        charSet.addAll(IntStream.rangeClosed(97, 122).boxed().toList());

        int hashCodeLength = hashCode.length();
        int charSetSize = charSet.size();

        for (int i = 0; i < 16; i++) {
            newHashCode.append(newCode[i % hashCodeLength]);
            newHashCode.append((char) (int) charSet.get(random.nextInt(charSetSize)));
            newHashCode.append(newCode[(i + 16) % hashCodeLength]);
            newHashCode.append((char) (int) charSet.get(random.nextInt(charSetSize)));
        }


        return newHashCode.toString();
    }
}
