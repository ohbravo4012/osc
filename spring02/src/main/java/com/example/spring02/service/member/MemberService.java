package com.example.spring02.service.member;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.spring02.model.member.dto.MemberVO;

public interface MemberService {
	// 회원 목록
	public List<MemberVO> memberList();

	// 회원 입력
	public void insertMember(MemberVO vo);

	// 회원 정보 상세보기
	public MemberVO viewMember(String userId);

	// 회원삭제
	public void deleteMember(String userId);

	// 회원정보 수정
	public void updateMember(MemberVO vo);

	// 비밀번호 체크
	public boolean checkPw(String userId, String userPw);

	// 01_01. 회원 로그인 체크
	public boolean loginCheck(MemberVO vo, HttpSession session);

	// 01_02. 회원 로그인 정보
	public MemberVO infoMember(MemberVO vo);

	// 02. 회원 로그아웃
	public void logout(HttpSession session);
}
