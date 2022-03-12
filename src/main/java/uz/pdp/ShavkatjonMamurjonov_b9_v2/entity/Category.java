package uz.pdp.ShavkatjonMamurjonov_b9_v2.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
@Column(nullable = false,unique = true)
    private String name;

    @ManyToOne
    private Library library;
}
