<?xml version="1.0" encoding="UTF-8"?>
<tileset name="tiles" tilewidth="32" tileheight="32" tilecount="8" columns="0">
 <grid orientation="orthogonal" width="1" height="1"/>
 <tile id="0">
  <properties>
   <property name="direction" type="int" value="0"/>
   <property name="entityId" value="WIND"/>
  </properties>
  <image width="32" height="32" source="../img/arrows.png"/>
 </tile>
 <tile id="1">
  <properties>
   <property name="entityId" value="BALLOON"/>
  </properties>
  <image width="32" height="32" source="../img/balloon.png"/>
 </tile>
 <tile id="2">
  <properties>
   <property name="entityId" value="GOAL"/>
  </properties>
  <image width="32" height="32" source="../img/goldStar.png"/>
 </tile>
 <tile id="3">
  <properties>
   <property name="entityId" value="DEATH"/>
  </properties>
  <image width="32" height="32" source="../img/mine.png"/>
 </tile>
 <tile id="4">
  <properties>
   <property name="entityId" value="MINOR_GOAL"/>
  </properties>
  <image width="32" height="32" source="../img/silverStar.png"/>
 </tile>
 <tile id="5">
  <properties>
   <property name="entityId" value="SQUARE_WALL"/>
  </properties>
  <image width="32" height="32" source="../img/squareWall.png"/>
 </tile>
 <tile id="6">
  <properties>
   <property name="endCellX" type="int" value="-1"/>
   <property name="endCellY" type="int" value="-1"/>
   <property name="entityId" value="MOVING_DEATH"/>
   <property name="period" type="int" value="-1"/>
  </properties>
  <image width="32" height="32" source="../img/mine-m.png"/>
 </tile>
 <tile id="7">
  <properties>
   <property name="direction" type="int" value="180"/>
   <property name="entityId" value="WIND"/>
  </properties>
  <image width="32" height="32" source="../img/arrows-l.png"/>
 </tile>
</tileset>
