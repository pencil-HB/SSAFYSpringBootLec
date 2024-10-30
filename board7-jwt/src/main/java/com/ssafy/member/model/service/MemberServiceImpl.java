package com.ssafy.member.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	
	private final MemberMapper memberMapper;

	public MemberServiceImpl(MemberMapper memberMapper) {
		super();
		this.memberMapper = memberMapper;
	}

	@Override
	public int idCheck(String userId) throws Exception {
		return memberMapper.idCheck(userId);
	}

	@Override
	public void joinMember(MemberDto memberDto) throws Exception {
		memberMapper.joinMember(memberDto);
	}

	@Override
	public MemberDto loginMember(MemberDto memberDto) throws Exception {
		return memberMapper.loginMember(memberDto);
	}
	
//	JWT
	@Override
	public void saveRefreshToken(String userId, String refreshToken) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("token", refreshToken);
		memberMapper.saveRefreshToken(map);
	}

	@Override
	public Object getRefreshToken(String userId) throws Exception {
		return memberMapper.getRefreshToken(userId);
	}

	@Override
	public void deleRefreshToken(String userId) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("userId", userId);
		map.put("token", null);
		memberMapper.deleteRefreshToken(map);
	}
	
	/* ADMIN */
	@Override
	public List<MemberDto> listMember(Map<String, Object> map) throws Exception {
		return memberMapper.listMember(map);
	}

	@Override
	public MemberDto getMember(String userId) throws Exception {
		return memberMapper.getMember(userId);
	}

	@Override
	public void updateMember(MemberDto memberDto) throws Exception {
		memberMapper.updateMember(memberDto);
	}

	@Override
	public void deleteMember(String userId) throws Exception {
		memberMapper.deleteMember(userId);		
	}

}
