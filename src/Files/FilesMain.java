package Files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Base64;
import java.util.concurrent.Executors;

public class FilesMain {

    public static void main(String[] args) {

        byte[] imageAsByteArray = getImageAsByteArray("/home/nms-barath/CODE/DSA/src/Files/Testing_Prov_06.png");
//        System.out.println("imageAsByteArray = " + Arrays.toString(imageAsByteArray));
        boolean b = generateImageFromBytes(imageAsByteArray, "/home/nms-barath/CODE/DSA/src/Files/t1.png");
//        System.out.println("b = " + b);
//        validate(imageAsByteArray);
        System.out.println("valid png  = "+isValidPng(imageAsByteArray));
        System.out.println("validatePngStructure png  = "+validatePngStructure(imageAsByteArray));
    }
    public static boolean validatePngStructure(byte[] byteArray) {
        if (!isValidPng(byteArray)) {
            return false; // Fail if the signature is invalid
        }

        // Check if the file contains an IHDR chunk
        int chunkStart = 8; // After the 8-byte signature
        if (byteArray.length < chunkStart + 8) {
            System.out.println("Invalid PNG: Missing IHDR chunk.");
            return false;
        }

        // The first 4 bytes after the signature should represent the chunk length
        int ihdrLength = ((byteArray[chunkStart] & 0xFF) << 24) |
                ((byteArray[chunkStart + 1] & 0xFF) << 16) |
                ((byteArray[chunkStart + 2] & 0xFF) << 8) |
                (byteArray[chunkStart + 3] & 0xFF);

        // The next 4 bytes should be "IHDR"
        String chunkType = new String(byteArray, chunkStart + 4, 4);
        if (!"IHDR".equals(chunkType)) {
            System.out.println("Invalid PNG: IHDR chunk missing or incorrect.");
            return false;
        }

        System.out.println("Valid PNG structure.");
        return true;
    }
    public static boolean isValidPng(byte[] byteArray) {
        // Check if the byte array is null or too small
        if (byteArray == null || byteArray.length < 8) {
            System.out.println("Invalid PNG: Byte array is null or too small.");
            return false;
        }

        // PNG file signature
        byte[] pngSignature = new byte[] {(byte) 0x89, (byte) 0x50, (byte) 0x4E, (byte) 0x47,
                (byte) 0x0D, (byte) 0x0A, (byte) 0x1A, (byte) 0x0A};

        // Validate the first 8 bytes against the PNG signature
        for (int i = 0; i < pngSignature.length; i++) {
            if (byteArray[i] != pngSignature[i]) {
                System.out.println("Invalid PNG: Signature mismatch.");
                return false;
            }
        }

        System.out.println("Valid PNG file.");
        return true;
    }
    public static void validate(byte[] byteArray){
        boolean isValid = true;
        for (byte b : byteArray) {
            if (b < 0) {
                b=0;
//                isValid = false;
//                break;
            }
        }
        if (!isValid) {

            System.out.println("Invalid byte array: Contains negative values.");
            throw new RuntimeException("Negative Values were present");
        }


        System.out.println(" %%%%%%%%%%%%%%%%%%%% VALIDATION ONE CROSSED %%%%%%%%%%%%%%%%%%%%" );
       /* boolean isValidAscii = true;
        for (byte b : byteArray) {
            if (b < 32 || b > 126) {
                isValidAscii = false;
                break;
            }
        }
        if (!isValidAscii) {
            System.out.println("Invalid byte array: Contains non-ASCII characters.");
            throw new RuntimeException("All  Values were not printable");
        }*/

        System.out.println(" %%%%%%%%%%%%%%%%%%%% VALIDATION TWO CROSSED %%%%%%%%%%%%%%%%%%%%" );

        try {
            validPattern(byteArray);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println(" %%%%%%%%%%%%%%%%%%%% VALIDATION THREE CROSSED %%%%%%%%%%%%%%%%%%%%" );


        // Example for checking if it's a PNG file
        if (byteArray[0] == (byte) 0x89 && byteArray[1] == (byte) 0x50 &&
                byteArray[2] == (byte) 0x4E && byteArray[3] == (byte) 0x47) {
            System.out.println("Valid PNG file.");
        } else {
            System.out.println("Invalid file format.");
        }

        System.out.println(" %%%%%%%%%%%%%%%%%%%% VALIDATION FOUR CROSSED %%%%%%%%%%%%%%%%%%%%" );

        try {
            byte[] decoded = Base64.getDecoder().decode(byteArray);
            System.out.println("Valid Base64 data.");
        } catch (IllegalArgumentException e) {
            System.out.println("Invalid Base64 data.");

        }

        System.out.println(" %%%%%%%%%%%%%%%%%%%% VALIDATION FIVE CROSSED %%%%%%%%%%%%%%%%%%%%" );

    }

    public static void validPattern(byte[] byteArray) throws NoSuchAlgorithmException {


        byte[] expectedHash = byteArray;
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        byte[] actualHash = md.digest(byteArray);
        if (!Arrays.equals(expectedHash, actualHash)) {
            System.out.println("Invalid byte array: Hash mismatch.");
        }

    }

    public static boolean generateImageFromBytes(byte[] imageBytes, String outputPath) {
        // Ensure the byte array is not null or empty
        if (imageBytes == null || imageBytes.length == 0) {
            System.out.println("Byte array is null or empty.");
            return false;
        }

        // Create a file object for the output path
        File outputFile = new File(outputPath);

        // Attempt to write the byte array to the file
        try (FileOutputStream fos = new FileOutputStream(outputFile)) {
            fos.write(imageBytes);
            System.out.println("Image successfully saved to: " + outputPath);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to save image.");
            return false;
        }
    }
    public static byte[] getImageAsByteArray(String imagePath) {
        File imageFile = new File(imagePath);

        // Check if the file exists
        if (!imageFile.exists()) {
            System.out.println("File does not exist: " + imagePath);
            return null;
        }

        // Read the file into a byte array
        try (FileInputStream fis = new FileInputStream(imageFile)) {
            byte[] byteArray = new byte[(int) imageFile.length()];
            fis.read(byteArray);
            return byteArray;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error reading the file: " + imagePath);
            return null;
        }
    }

}
