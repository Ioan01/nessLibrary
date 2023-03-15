package ac.labs.library.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

@Data
@With
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    private int Id;

    private String Title;

    private String Author;

}
