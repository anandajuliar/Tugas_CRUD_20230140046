package com.tugas.tugasktp.service;

import com.tugas.tugasktp.model.Ktp;
import com.tugas.tugasktp.repository.KtpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class KtpServiceImpl implements KtpService {

    @Autowired
    private KtpRepository ktpRepository;

    @Override
    public Ktp addKtp(Ktp ktp) {
        if (ktpRepository.existsByNomorKtp(ktp.getNomorKtp())) {
            throw new RuntimeException("Nomor KTP sudah terdaftar!");
        }
        return ktpRepository.save(ktp);
    }

    @Override
    public List<Ktp> getAllKtp() {
        return ktpRepository.findAll();
    }

    @Override
    public Ktp getKtpById(Integer id) {
        return ktpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Data KTP tidak ditemukan"));
    }

    @Override
    public Ktp updateKtp(Integer id, Ktp request) {
        Ktp existingKtp = getKtpById(id);

        existingKtp.setNamaLengkap(request.getNamaLengkap());
        existingKtp.setAlamat(request.getAlamat());
        existingKtp.setTanggalLahir(request.getTanggalLahir());
        existingKtp.setJenisKelamin(request.getJenisKelamin());

        return ktpRepository.save(existingKtp);
    }

    @Override
    public void deleteKtp(Integer id) {
        Ktp existingKtp = getKtpById(id);
        ktpRepository.delete(existingKtp);
    }
}