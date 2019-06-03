package com.example.spring02.model.member.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.spring02.model.member.dto.MemberVO;

@Repository // 현재 클래스를 스프링에서 관리하는 dao bean으로 등록
public class MemberDAOImpl implements MemberDAO {
	// SqlSession 객체를 스프핑에서 생성하여 주입
	// 의존관계 주입(Dependency Injection), 느슨한 결합
	@Inject
	SqlSession sqlSession; // mybatis 실행 객체

	// 01. 전체 회원 목록 조회
	@Override
	public List<MemberVO> memberList() {
		return sqlSession.selectList("member.memberList");
	}

	// 02. 회원 등록
	@Override
	public void insertMember(MemberVO vo) {
		sqlSession.insert("member.insertMember", vo);
	}

	// 03. 회원 정보 상세 조회
	@Override
	public MemberVO viewMember(String userId) {
		return sqlSession.selectOne("member.viewMember", userId);
	}

	// 04. 회원 정보 수정 처리
	@Override
	public void deleteMember(String userId) {
		sqlSession.delete("member.deleteMember", userId);
	}

	// 05. 회원 정보 삭제 처리
	@Override
	public void updateMember(MemberVO vo) {
		sqlSession.update("member.updateMember", vo);

	}

	// 06. 회원 정보 수정 및 삭제를 위한 비밀번호 체크
	@Override
	public boolean checkPw(String userId, String userPw) {
		boolean result = false;
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("userPw", userPw);
		int count = sqlSession.selectOne("member.checkPw", map);
		if (count == 1)
			result = true;
		return result;
	}

	// 01_01. 회원 로그인체크
	@Override
	public boolean loginCheck(MemberVO vo) {
		String name = sqlSession.selectOne("member.loginCheck", vo);
		//String name = sqlSession.selectOne("member.loginBcrypt", vo);
		return (name == null) ? false : true;
	}

	// 01_02. 회원 로그인 정보
	@Override
	public MemberVO infoMember(MemberVO vo) {
		return sqlSession.selectOne("member.infoMember", vo);
	}

	// 02. 회원 로그아웃
	@Override
	public void logout(HttpSession sessin) {
	}
}
