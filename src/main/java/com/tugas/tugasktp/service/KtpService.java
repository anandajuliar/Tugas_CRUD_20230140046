package com.tugas.tugasktp.service;

import com.tugas.tugasktp.model.Ktp;
import java.util.List;

public interface KtpService {
    Ktp addKtp(Ktp ktp);
    List<Ktp> getAllKtp();
    Ktp getKtpById(Integer id);
    Ktp updateKtp(Integer id, Ktp ktp);
    void deleteKtp(Integer id);
}