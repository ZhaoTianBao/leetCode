package generate;

import generate.CiAccountInfo;

/**
 * @Entity generate.CiAccountInfo
 */
public interface CiAccountInfoDao {
    /**
     *
     * @mbg.generated 2022-01-10 22:33:57
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2022-01-10 22:33:57
     */
    int insert(CiAccountInfo record);

    /**
     *
     * @mbg.generated 2022-01-10 22:33:57
     */
    int insertSelective(CiAccountInfo record);

    /**
     *
     * @mbg.generated 2022-01-10 22:33:57
     */
    CiAccountInfo selectByPrimaryKey(Integer id);

    /**
     *
     * @mbg.generated 2022-01-10 22:33:57
     */
    int updateByPrimaryKeySelective(CiAccountInfo record);

    /**
     *
     * @mbg.generated 2022-01-10 22:33:57
     */
    int updateByPrimaryKey(CiAccountInfo record);
}