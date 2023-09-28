package com.qodev.tech.service.cryptograph;

import com.qodev.tech.common.GenericResponseDTO;
import com.qodev.tech.dto.request.encodeRequest;
import com.qodev.tech.dto.response.encodeResponse;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.util.Base64;

@ApplicationScoped
@Transactional
public class aesService {

    public GenericResponseDTO aes32(encodeRequest req) throws InvalidKeyException, NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException, IllegalBlockSizeException, BadPaddingException {
        encodeResponse res = new encodeResponse();
        Security.addProvider(new BouncyCastleProvider());

        String key = req.getaKey() + req.getbKey() + req.getcKey();

        // Inisialisasi kunci rahasia
        byte[] keyBytes = new byte[32];
        System.arraycopy(key.getBytes(), 0, keyBytes, 0, Math.min(key.getBytes().length, 32));
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
        return new GenericResponseDTO().successResponse(res);
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
