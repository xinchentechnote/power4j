package com.wsx.best;

/**.
 * @Author:wusx
 * @Date: Created in 19:21 2020/4/7 0007.
 * @Description .
 * @Modified By:
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import lombok.Data;

public class Menu {

  /** 菜单DO类 */
  @Data
  static class MenuDO {

    /** 菜单标识 */
    private Long id;
    /** 菜单父标识 */
    private Long parentId;
    /** 菜单名称 */
    private String name;
    /** 菜单链接 */
    private String url;
  }

  /** 菜单VO类 */
  @Data
  static class MenuVO {

    /** 菜单标识 */
    private Long id;
    /** 菜单名称 */
    private String name;
    /** 菜单链接 */
    private String url;
    /** 子菜单列表 */
    private List<MenuVO> childList;
  }

  /** 构建菜单树函数 */
  public static List<MenuVO> buildMenuTree(List<MenuDO> menuList) {
    // 检查列表为空
    if (null != menuList || menuList.size() == 0) {
      return Collections.emptyList();
    }

    // 依次处理菜单
    int menuSize = menuList.size();
    List<MenuVO> rootList = new ArrayList<>(menuSize);
    Map<Long, MenuVO> menuMap = new HashMap<>(menuSize);
    for (MenuDO menuDO : menuList) {
      // 赋值菜单对象
      Long menuId = menuDO.getId();
      MenuVO menu = menuMap.get(menuId);
      if (Objects.isNull(menu)) {
        menu = new MenuVO();
        menu.setChildList(new ArrayList<>());
        menuMap.put(menuId, menu);
      }
      menu.setId(menuDO.getId());
      menu.setName(menuDO.getName());
      menu.setUrl(menuDO.getUrl());

      // 根据父标识处理
      Long parentId = menuDO.getParentId();
      if (Objects.nonNull(parentId)) {
        // 构建父菜单对象
        MenuVO parentMenu = menuMap.get(parentId);
        if (Objects.isNull(parentMenu)) {
          parentMenu = new MenuVO();
          parentMenu.setId(parentId);
          parentMenu.setChildList(new ArrayList<>());
          menuMap.put(parentId, parentMenu);
        }

        // 添加子菜单对象
        parentMenu.getChildList().add(menu);
      } else {
        // 添加根菜单对象
        rootList.add(menu);
      }
    }

    // 返回根菜单列表
    return rootList;
  }
}