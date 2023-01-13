package be.technifutur.java.mvc.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hotel {

    private long ID;

    private int nbrEtoiles;

    private String nom;

    private String nomReceptionist;

    private String adresse;

    private List<Room> rooms;

}
