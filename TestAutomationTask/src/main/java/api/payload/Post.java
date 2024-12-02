package api.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@Builder
@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Post {
	private int userId;
	private int id;
	private String title;
	private String body;
	
	
	
	

	
}
