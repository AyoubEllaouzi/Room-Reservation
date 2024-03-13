package fr.norsys.reservation_salles.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Invalid roomId: Name is NULL")
    @Size(min = 3, max = 30, message = "Invalid roomId: Must be of 3 - 30 characters")
    private String roomId;
    @Min(value = 10, message = "Capacity must be at least 10")
    @Max(value = 20, message = "Capacity cannot exceed 20")
    private int capacity;

}
