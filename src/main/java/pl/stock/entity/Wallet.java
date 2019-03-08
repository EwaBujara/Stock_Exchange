package pl.stock.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SE_wallets")
public class Wallet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "wallet")
    private User user;

    @ManyToMany
    private List<WalletItem> walletItems;


    public Wallet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<WalletItem> getWalletItems() {
        return walletItems;
    }

    public void setWalletItems(List<WalletItem> walletItems) {
        this.walletItems = walletItems;
    }
}
