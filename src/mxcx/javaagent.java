package mxcx;

import java.io.*;
import java.lang.instrument.*;
import java.security.*;

/**
 * 
 * @author mxcx@fosec.vn
 * This Java Agent to real time replace 2 class:
 * + larry/lau/burp/ui/TestDisclaimer: I have not really understood everything in the larry's original class, so I replaced it.
 * + burp/uzd: This class stores license informations, so I replace it to extend the license and modify the license name.
 * 
 */

public class javaagent
{
    public static boolean binvalidation = true;
    //A java agent must have a premain method which acts as the entry-point
    public static void premain(String agentArgs, Instrumentation inst) throws NoSuchFieldException, IllegalAccessException, UnmodifiableClassException
    {
        inst.addTransformer(new transformer());
    }
}

class transformer implements ClassFileTransformer
{
    // xxd -p <class file> | tr -d '\n'
    String TestDisclaimerClass = "cafebabe0000003400250700020100206c617272792f6c61752f627572702f75692f54657374446973636c61696d65720700040100106a6176612f6c616e672f4f626a6563740100063c696e69743e010003282956010004436f64650a000300090c0005000601000f4c696e654e756d6265725461626c650100124c6f63616c5661726961626c655461626c65010004746869730100224c6c617272792f6c61752f627572702f75692f54657374446973636c61696d65723b01000765786563757465010013284c6a6176612f7574696c2f4c6973743b295a01000a457863657074696f6e730700120100136a6176612f6c616e672f457863657074696f6e0100095369676e6174757265010027284c6a6176612f7574696c2f4c6973743c4c6a6176612f6c616e672f537472696e673b3e3b295a0800160100345468616e6b20796f7520616c6c206d79207072656465636573736f727320666f7220796f7572206772656174206566666f72742e08001801001942757270556e6c696d697465642075706461746520627920460a001a001c07001b0100176a617661782f7377696e672f4a4f7074696f6e50616e650c001d001e01001173686f774d6573736167654469616c6f6701003c284c6a6176612f6177742f436f6d706f6e656e743b4c6a6176612f6c616e672f4f626a6563743b4c6a6176612f6c616e672f537472696e673b492956010008646973636c61696d0100104c6a6176612f7574696c2f4c6973743b0100164c6f63616c5661726961626c65547970655461626c650100244c6a6176612f7574696c2f4c6973743c4c6a6176612f6c616e672f537472696e673b3e3b01000a536f7572636546696c6501001354657374446973636c61696d65722e6a617661002100010003000000000002000100050006000100070000002f00010001000000052ab70008b100000002000a0000000600010000000d000b0000000c000100000005000c000d00000008000e000f0003001000000004000100110013000000020014000700000053000400010000000b011215121705b8001904ac00000003000a00000012000400000010000300110006001000090012000b0000000c00010000000b001f0020000000210000000c00010000000b001f0022000000010023000000020024";
    String wkcClass = "cafebabe000000340071070002010008627572702f776b630700040100106a6176612f6c616e672f4f626a656374010001630100124c6a6176612f6c616e672f537472696e673b0100016401000168010001620100014a01000161010001490100016501000a4c627572702f6b39663b01000167010001660100063c696e69743e010058284c6a6176612f6c616e672f537472696e673b4c6a6176612f6c616e672f537472696e673b4c6a6176612f6c616e672f537472696e673b4a494c627572702f6b39663b494c6a6176612f6c616e672f537472696e673b2956010004436f64650a000300150c0011001601000328295609000100180c00050006090001001a0c0007000607001c0100176a6176612f6c616e672f537472696e674275696c6465720a001e002007001f0100106a6176612f6c616e672f537472696e670c0021002201000776616c75654f66010026284c6a6176612f6c616e672f4f626a6563743b294c6a6176612f6c616e672f537472696e673b0a001b00240c00110025010015284c6a6176612f6c616e672f537472696e673b2956080027010018202d20556e6c696d697465642075706461746520627920460a001b00290c002a002b010006617070656e6401002d284c6a6176612f6c616e672f537472696e673b294c6a6176612f6c616e672f537472696e674275696c6465723b0a001b002d0c002e002f010008746f537472696e6701001428294c6a6176612f6c616e672f537472696e673b09000100310c00080006050000e675657616c009000100350c0009000a09000100370c000b000c09000100390c000d000e090001003b0c000f000c090001003d0c0010000601000f4c696e654e756d6265725461626c650100124c6f63616c5661726961626c655461626c650100047468697301000a4c627572702f776b633b010031284c6a6176612f6c616e672f537472696e673b5b4c6a6176612f6c616e672f4f626a6563743b294c627572702f776b633b0900440046070045010008627572702f7968640c000b00470100015a07004901000e6a6176612f6c616e672f4c6f6e670a0048004b0c004c004d0100096c6f6e6756616c756501000328294a07004f0100116a6176612f6c616e672f496e74656765720a004e00510c00520053010008696e7456616c75650100032829490a00550057070056010008627572702f6b39660c0058005901000774797065466f7201001e284c6a6176612f6c616e672f537472696e673b294c627572702f6b39663b0a004e005b0c005c005d0100087061727365496e74010015284c6a6176612f6c616e672f537472696e673b29490a0001005f0c001100120900610046070062010008627572702f6c34630100017301000561727261790100135b4c6a6176612f6c616e672f4f626a6563743b010003776b6301000d537461636b4d61705461626c6507006501001228294c6a6176612f7574696c2f446174653b07006b01000e6a6176612f7574696c2f446174650a006a006d0c0011006e010004284a295601000a536f7572636546696c65010008776b632e6a6176610021000100030000000800110005000600000011000700060000001100080006000000110009000a00000011000b000c00000011000d000e00000011000f000c00000011001000060000000300020011001200010013000000e30004000a000000452ab700142a2bb500172a2cb500192abb001b592db8001db700231226b60028b6002cb500302a140032b500342a1506b500362a1907b500382a1508b5003a2a1909b5003cb100000002003e0000002a000a000000100004001100090012000e001300250014002c00150032001600380017003e001800440019003f0000005c000900000045004000410000000000450005000600010000004500070006000200000045000800060003000000450009000a000400000045000b000c000600000045000d000e000700000045000f000c0008000000450010000600090009000b004200010013000001af000c000400000077b200433dbb0001592a2b0332c0001e2b0432c0001e2b0532c00048b6004a2b0632c0004eb600502bbe07a4000c2b0732c0001ea7000401b800542bbe08a4000f2b0832c0001eb8005aa70004032bbe1006a4000d2b100632c0001ea7000401b7005e4eb2006099000f1c99000703a7000404b300432db000000003003e0000001600050000001c0004001d0063001e0069001f00750021003f0000002a0004000000770063000600000000007700640065000100040073000b00470002006300140066004100030067000000da0009ff0036000307001e07006801000708000408000407001e07001e07001e0401ff0000000307001e07006801000808000408000407001e07001e07001e040107001eff0014000307001e07006801000808000408000407001e07001e07001e0401070055ff0000000307001e07006801000908000408000407001e07001e07001e040107005501ff0010000307001e07006801000908000408000407001e07001e07001e040107005501ff0000000307001e07006801000a08000408000407001e07001e07001e04010700550107001efc00110700014001020001000b00690001001300000036000400010000000cbb006a592ab40034b7006cb000000002003e00000006000100000025003f0000000c00010000000c0040004100000001006f000000020070";
    
    Instrumentation inst;
    
    static byte[] str2bs(final String str) throws IOException {
        final ByteArrayOutputStream baos = new ByteArrayOutputStream();
        for (int i = 0; i < str.length(); i += 2) {
            baos.write(Integer.parseInt(str.substring(i, i + 2), 16));
        }
        baos.close();
        return baos.toByteArray();
    }
    
    public void setInstrumentation(Instrumentation in){
        inst = in;
    }
    
    public byte[] transform(ClassLoader loader, String className,
            Class<?> classBeingRedefined, ProtectionDomain protectionDomain,
            byte[] classfileBuffer) throws IllegalClassFormatException {
        if (className != null) {
            if (className.startsWith("larry/lau/burp/ui/TestDisclaimer")) {
                System.out.println(className);
                try {
                   return str2bs(TestDisclaimerClass);
                } catch (IOException ex) {
                    System.out.println(transformer.class.getName());
                }
            }
            else if (className.startsWith("burp/wkc")) {
                System.out.println(className);
                try {
                    return str2bs(wkcClass);
                } catch (IOException ex) {
                    System.out.println(transformer.class.getName());
                }
            }
        }
        return classfileBuffer;
    }
 }