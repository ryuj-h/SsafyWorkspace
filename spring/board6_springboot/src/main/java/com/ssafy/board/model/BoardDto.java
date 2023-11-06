package com.ssafy.board.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor//인자값이 요구가 되는 생성자
@NoArgsConstructor//default 생성자
@RequiredArgsConstructor
public class BoardDto {

	@NonNull
	private int articleNo;
	@NonNull
	private String userId;
	private String userName;
	private String subject;
	private String content;
	private int hit;
	private String registerTime;
	private List<FileInfoDto> fileInfos;

}
