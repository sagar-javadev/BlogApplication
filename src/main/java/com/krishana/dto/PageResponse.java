package com.krishana.dto;

import java.util.List;

import org.springframework.data.domain.Sort;

import com.krishana.entity.Post;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class PageResponse {
	
	private List<PostDto> content;
	
	private Integer pageNumber;
	private Integer pageSize;
	private Long totalElements;
	private boolean lastPage;
	private Sort sortBy;
	

}
