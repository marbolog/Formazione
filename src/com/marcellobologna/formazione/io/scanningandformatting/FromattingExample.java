package com.marcellobologna.formazione.io.scanningandformatting;

/**
 * Created by Marcello Bologna on 23/03/17.
 * <p>
 * The format method formats multiple arguments based on a format string. The format string consists of static text
 * embedded with format specifiers; except for the format specifiers, the format string is output unchanged.
 */
public class FromattingExample {

    public static void main(String[] args) {
        int i = 2;
        double r = Math.sqrt(i);

        /*
        Like the three used in this example, all format specifiers begin with a % and end with a 1- or 2-character conversion that specifies the kind of formatted output being generated. The three conversions used here are:

        . d formats an integer value as a decimal value.
        . f formats a floating point value as a decimal value.
        . n outputs a platform-specific line terminator.

        Here are some other conversions:

        . x formats an integer as a hexadecimal value.
        . s formats any value as a string.
        . tB formats an integer as a locale-specific month name.

         */

        System.out.format("The square root of %d is %f.%n", i, r);

        /*
        The elements must appear in the order shown. Working from the right, the optional elements are:

        . Conversion: see above
        . Precision. For floating point values, this is the mathematical precision of the formatted value. For s and other general conversions, this is the maximum width of the formatted value; the value is right-truncated if necessary.
        . Width. The minimum width of the formatted value; the value is padded if necessary. By default the value is left-padded with blanks.
        . Flags specify additional formatting options. In the Format example, the + flag specifies that the number should always be formatted with a sign, and the 0 flag specifies that 0 is the padding character. Other flags include - (pad on the right) and , (format number with locale-specific thousands separators). Note that some flags cannot be used with certain other flags or with certain conversions.
        . The Argument Index allows you to explicitly match a designated argument. You can also specify < to match the same argument as the previous specifier. Thus the example could have said: System.out.format("%f, %<+020.10f %n", Math.PI);

         */

        System.out.format("%f, %1$+020.10f %n", Math.PI);

    }

}
