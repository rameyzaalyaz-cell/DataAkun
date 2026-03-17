public class AkunBank {
    private String namaAkun;
    private String noRekening;
    private String password;
    private double saldo;

    
    public AkunBank(String namaAkun, String noRekening, String password, double saldo) {
        setNamaAkun(namaAkun);
        setNoRekening(noRekening);
        setPassword(password);

        if (saldo >= 0) {
            this.saldo = saldo;
        } else {
            System.out.println("Saldo awal tidak boleh minus!");
            this.saldo = 0;
        }
    }

   
    public void setNamaAkun(String namaAkun) {
        if (namaAkun != null && namaAkun.length() >= 4) {
            this.namaAkun = namaAkun;
        } else {
            System.out.println("Nama akun minimal 4 karakter!");
        }
    }

    
    public void setNoRekening(String noRekening) {
        if (noRekening != null && noRekening.length() >= 10) {
            this.noRekening = noRekening;
        } else {
            System.out.println("Nomor rekening minimal 10 karakter!");
        }
    }

   
    public void setPassword(String password) {
        if (password != null && password.length() >= 8 && password.contains("_")) {
            this.password = password;
        } else {
            System.out.println("Password minimal 8 karakter dan harus mengandung underscore (_)");
        }
    }

    
    private boolean cekPassword(String inputPw) {
        return this.password.equals(inputPw);
    }

    
    public void tambahSaldo(double jumlah, String inputPw) {
        if (!cekPassword(inputPw)) {
            System.out.println("Password salah! Transaksi gagal.");
            return;
        }

        if (jumlah > 0) {
            saldo += jumlah;
            System.out.println("Saldo berhasil ditambah. Saldo sekarang: " + saldo);
        } else {
            System.out.println("Jumlah tidak valid!");
        }
    }

   
    public void tarikSaldo(double jumlah, String inputPw) {
        if (!cekPassword(inputPw)) {
            System.out.println("Password salah! Transaksi gagal.");
            return;
        }

        if (jumlah > saldo) {
            System.out.println("Saldo tidak mencukupi!");
        } else if (jumlah > 0) {
            saldo -= jumlah;
            System.out.println("Berhasil tarik saldo. Sisa saldo: " + saldo);
        } else {
            System.out.println("Jumlah tidak valid!");
        }
    }

    // Getter saldo
    public double getSaldo() {
        return saldo;
    }

    
    public void tampilkanInfo() {
        System.out.println("Nama Akun   : " + namaAkun);
        System.out.println("No Rekening : " + noRekening);
        System.out.println("Saldo       : " + saldo);
    }
}
