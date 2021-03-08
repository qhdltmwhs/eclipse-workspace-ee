﻿package com.itwill.board;

import java.sql.SQLException;
import java.util.List;

import com.itwill.util.PageInputDto;
import com.itwill.util.BoardListPageDto;
import com.itwill.util.PageCalculator;

public class BoardService {
	private static BoardService _instance;
	
	private BoardDao boardDao;
	private  BoardService() {
		boardDao=new BoardDao();
	}
	public static BoardService getInstance() {
		if(_instance==null) {
			_instance=new BoardService();
		}
		return _instance;
	}
	/*
	 * 게시물삭제
	 */
	public int remove(int boardno) throws Exception,BoardException{
		Board tempBoard=boardDao.findBoard(boardno);
		boolean rExist=boardDao.countReplay(tempBoard);
		System.out.println("답글존재여부:"+rExist);
		if(boardDao.countReplay(tempBoard)){
			//답글존재
			throw new BoardException("답글이 있는 게시글은 삭제앙돼요!!");
		}else{
			//답글안존재
			return boardDao.remove(tempBoard.getBoardNo());
		}
		//return getBoardDao().remove(boardno);
	}
	
	/*
	 * 답글쓰기
	 */
	public int createReplay(Board board){
		return boardDao.createReply(board);
	}
	/*
	 * 게시물 1개
	 */
	public Board findBoard(int boardNo)throws Exception{
		Board board=boardDao.findBoard(boardNo);
		return board;
	}
	public void updateHitCount(int boardNo){
		boardDao.increaseReadCount(boardNo);
	}
	/*
	 * 게시물리스트
	 */
	public BoardListPageDto findBoardList(PageInputDto pageConfig){
		//1.전체글의 갯수
		int totalRecordCount = boardDao.getBoardCount();
		//ListResultBean 클래스-->결과데이타 DTO,VO(Board ArrayList + Paging)
		
		//2.paging계산(PageCounter 유틸클래스)
		BoardListPageDto boardListPageDto=PageCalculator.getPagingInfo(
								Integer.parseInt(pageConfig.getSelectPage()),
								pageConfig.getRowCountPerPage(),
								pageConfig.getPageCountPerPage(),
								totalRecordCount);
		
		//3.게시물데이타 얻기
		List<Board> boardList=
				boardDao.findBoardList(boardListPageDto.getStartRowNum(),
											boardListPageDto.getEndRowNum());
		boardListPageDto.setList(boardList);
		
		return boardListPageDto;
	}
	/*
	 * 게시물생성
	 */
	public int create(Board board){
		return  boardDao.create(board);
	}
	/*
	 * 게시물수정
	 */
	public int update(Board board) throws SQLException {
		return boardDao.update(board);
	}
	
}
