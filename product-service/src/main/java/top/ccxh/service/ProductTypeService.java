package top.ccxh.service;

import top.ccxh.mapper.pojo.PageModel;
import top.ccxh.mapper.pojo.ProductType;

import java.util.List;

/**
 * 操作类型
 */
public interface ProductTypeService {
    /**
     * 返回所有分类 参数 是0的
     * @return
     */
    List<ProductType> selectAll();

    /**
     * 批量 删除
     * @param ids
     * @return
     */
    boolean bathDeleteProductTypeById(List<Integer> ids);

    /**
     * 更新非空字段
     * @param productType
     * @return
     */
    boolean updateProductTypeById(ProductType productType);

    /**
     * 根据主键更新状态
     * @param id
     * @param status
     * @return
     */
    boolean updateProductTypeStatusById(Integer id, Integer status);

    /**
     * 添加一个分类
     * @param productType
     * @return
     */
    boolean addProductType(ProductType productType);

    /**
     * 分页
     * @return
     */
    PageModel limitPage(PageModel pageModel);

    /**
     * 检查名字是否重复
     * @param name
     * @return
     */
    boolean checkName(String name);
}
