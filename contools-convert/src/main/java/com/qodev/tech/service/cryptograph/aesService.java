package com.qodev.tech.service.cryptograph;

import com.qodev.tech.common.GenericResponseDTO;
import com.qodev.tech.dto.request.encodeRequest;
import com.qodev.tech.dto.response.encodeResponse;
import io.vertx.core.json.JsonObject;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.security.Security;
import java.util.Base64;

@ApplicationScoped
@Transactional
public class aesService {

    public GenericResponseDTO aes32(encodeRequest req){
        switch (req.getType().toLowerCase()){
            case "":
                return new GenericResponseDTO().errorResponse(400,"Bad Request");
            case "encode":
                return encodeAES32(req);
            case "decode":
                return decodeAES32(req);
            default:
                return new GenericResponseDTO().errorResponse(400,"Bad Request");
        }
    }

    private GenericResponseDTO encodeAES32(encodeRequest req){
        long start = System.currentTimeMillis();
        System.out.println(String.format("[[ %s ]]-------------------- aes32: START --------------------",req.getType()));

        encodeResponse res = new encodeResponse();

        try {
            Security.addProvider(new BouncyCastleProvider());

            String key = req.getaKey() + req.getbKey() + req.getcKey();

            // Inisialisasi kunci rahasia
            byte[] keyBytes = new byte[24];
            System.arraycopy(key.getBytes(), 0, keyBytes, 0, Math.min(key.getBytes().length, 24));
            SecretKey secretKey = new SecretKeySpec(keyBytes, "AES");

            // Buat objek Cipher
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");

            // Inisialisasi mode enkripsi
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);

            // Enkripsi data
            byte[] encryptedData = cipher.doFinal(req.getInput().getBytes());

            // Konversi hasil enkripsi ke Base64
            String encryptedDataStr = Base64.getEncoder().encodeToString(encryptedData);

            res.setEncode(encryptedDataStr);

            long stop = System.currentTimeMillis();
            System.out.println(String.format("[[ %s ]]-------------------- aes32: RESULT [[ %s ]] --------------------", req.getType(), JsonObject.mapFrom(res).encode()));
            System.out.println(String.format("[[ %s ]]-------------------- aes32: END %s ms --------------------", req.getType(), (stop - start)));
            return new GenericResponseDTO().successResponse(res);
        } catch (Exception e) {
            // Tangani kesalahan jika terjadi
            e.printStackTrace();
            return new GenericResponseDTO().errorResponse(204,"Terjadi kesalahan dalam enkripsi.");
        }
    }

    private GenericResponseDTO decodeAES32(encodeRequest req) {
        long start = System.currentTimeMillis();
        System.out.println(String.format("[[ %s ]]-------------------- aes32: START --------------------", req.getType()));

        encodeResponse res = new encodeResponse();

        try {
            Security.addProvider(new BouncyCastleProvider());

            String key = req.getaKey() + req.getbKey() + req.getcKey();

            // Inisialisasi kunci rahasia
            byte[] keyBytes = new byte[32];
            System.arraycopy(key.getBytes(), 0, keyBytes, 0, Math.min(key.getBytes().length, 32));
            SecretKey secretKey = new SecretKeySpec(keyBytes, "AES");

            // Buat objek Cipher
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS7Padding", "BC");

            // Inisialisasi mode dekripsi
            cipher.init(Cipher.DECRYPT_MODE, secretKey);

            // Dekripsi data
            byte[] decodedData = cipher.doFinal(Base64.getDecoder().decode(req.getInput()));

            // Konversi hasil dekripsi ke string
            String decryptedDataStr = new String(decodedData);

            res.setEncode(decryptedDataStr);

            long stop = System.currentTimeMillis();
            System.out.println(String.format("[[ %s ]]-------------------- aes32: RESULT [[ %s ]] --------------------", req.getType(), JsonObject.mapFrom(res).encode()));
            System.out.println(String.format("[[ %s ]]-------------------- aes32: END %s ms --------------------", req.getType(), (stop - start)));
            return new GenericResponseDTO().successResponse(res);
        } catch (Exception e) {
            // Tangani kesalahan jika terjadi
            e.printStackTrace();
            return new GenericResponseDTO().errorResponse(204,"Terjadi kesalahan dalam dekripsi.");
        }
    }


    public GenericResponseDTO aes64(encodeRequest req){
        return null;
    }

    public GenericResponseDTO aes128(encodeRequest req){
        return null;
    }

    public GenericResponseDTO aes192(encodeRequest req){
        return null;
    }

    public GenericResponseDTO aes256(encodeRequest req){
        return null;
    }
}
