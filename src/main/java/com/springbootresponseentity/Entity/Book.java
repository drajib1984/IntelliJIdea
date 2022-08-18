package com.springbootresponseentity.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    @Id
    @SequenceGenerator( name ="sequence_id" , sequenceName ="sequence_id" ,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "sequence_id")
    private int id;

    private String title;

    private String author;
}
