<?xml version="1.0" encoding="UTF-8"?>
<tileset name="tiles" tilewidth="32" tileheight="32" tilecount="64" columns="8">
 <image source="platforms.png" trans="ffffff" width="256" height="256"/>
 <tile id="1">
  <properties>
   <property name="entityId" value="MINOR_GOAL"/>
  </properties>
 </tile>
 <tile id="9">
  <properties>
   <property name="entityId" value="SQUARE_WALL"/>
  </properties>
 </tile>
 <tile id="20">
  <properties>
   <property name="entityId" value="GOAL"/>
  </properties>
 </tile>
 <tile id="37">
  <properties>
   <property name="entityId" value="WIND"/>
  </properties>
 </tile>
 <tile id="52">
  <properties>
   <property name="entityId" value="DEATH"/>
  </properties>
 </tile>
 <tile id="53">
  <properties>
   <property name="entityId" value="BALLOON"/>
  </properties>
 </tile>
 <tile id="56">
  <properties>
   <property name="endCellX" type="int" value="0"/>
   <property name="endCellY" type="int" value="0"/>
   <property name="entityId" value="MOVING_DEATH"/>
   <property name="period" type="int" value="0"/>
  </properties>
 </tile>
</tileset>
