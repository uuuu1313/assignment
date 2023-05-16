package models.emp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.transaction.annotation.Transactional;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Transactional
public class EmpDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private PreparedStatement pstmt = null;

    /** 데이터 추가 */
    public long insertEmp(Emp emp){
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO EMP2 (EMPNO, ENAME, JOB) VALUES (EMP2_SEQ.nextval, ?, ?)";
        jdbcTemplate.update(con -> {
            pstmt = con.prepareStatement(sql, new String[]{"EMPNO"});
            pstmt.setString(1, emp.getENAME());
            pstmt.setString(2, emp.getJOB());

            return pstmt;
        }, keyHolder);

        Number key = keyHolder.getKey();
        long EMPNO = key.longValue();

        return EMPNO;
    }

    /** 데이터 수정 */
    public void updateEmpJob(Emp emp){
        String sql = "UPDATE EMP2 SET JOB = ? WHERE ENAME =?";
        jdbcTemplate.update(con -> {
           pstmt = con.prepareStatement(sql);
           pstmt.setString(1, emp.getJOB());
           pstmt.setString(2, emp.getENAME());

           return pstmt;
        });

        System.out.println("ENAME : " + emp.getENAME() + "의 JOB을 " + emp.getJOB() + "으로 변경!");
    }


    /** 데이터 삭제 */
    public void deleteEmpNo(int no){
        String sql = "DELETE FROM EMP2 WHERE EMPNO = ?";
        jdbcTemplate.update(con -> {
           pstmt = con.prepareStatement(sql);
           pstmt.setLong(1, no);

            return pstmt;
        });
        System.out.println("EMPNO : " + no + " 데이터 삭제!");
    }

    /** 데이터 조회 */
//    public List<Emp> getEmpJob(String JOB){
//        String sql = "SELECT * FROM EMP2 WHERE JOB = ?";
//        jdbcTemplate.query(con -> {
//
//        }, this::mapper);
//    }

    /** 데이터 조회 */
    public Emp get(long EMPNO){
        try {
            String sql = "SELECT * FROM EMP WHERE EMPNO = ?";
            Emp emp = jdbcTemplate.queryForObject(sql, this::mapper, EMPNO);

            return emp;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    

    private Emp mapper(ResultSet rs, int i) throws  SQLException{
        Emp emp = new Emp();
        emp.setEMPNO(rs.getLong("EMPNO"));
        emp.setENAME(rs.getString("ENAME"));
        emp.setJOB(rs.getString("JOB"));

        return emp;
    }
}
