package com.model.image;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

public class ImageMapperTest {

	private ImageMapper cut = new ImageMapper();

	@Test
	public void testMapEntityToDto_NotNull() {
		ImageEntity expected = ImageFactory.generateRandomImageEntity();

		ImageDTO result = cut.mapEntityToDto(expected);

		ImageEntity actual = cut.mapDtoToEntity(result);

		assertEquals(expected.getId(), actual.getId());

		assertEquals(expected.getPicture(), actual.getPicture());
	}
	
	@Test
	public void testMapEntityToDto_Null() {
		assertNull(cut.mapEntityToDto(null));
	}

	@Test
	public void testMapDtoToEntity_NotNull() {
		ImageDTO expected = ImageFactory.generateRandomImageDTO();

		ImageEntity result = cut.mapDtoToEntity(expected);

		ImageDTO actual = cut.mapEntityToDto(result);

		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getPicture(), actual.getPicture());
	}

	@Test
	public void testMapDtoToEntity_Null() {
		assertNull(cut.mapDtoToEntity(null));
	}
	
	
	@Test
	public void testMapEntitiesToDto_NotNull(){
		List<ImageEntity> expected = ImageFactory.generateRandomImageEntities(RandomUtils.nextInt(0, 100));
		
		List<ImageDTO> result = cut.mapEntitiesToDto(expected);
		
		List<ImageEntity> actual = cut.mapDtosToEntity(result);
	
		assertEquals(expected.size(), actual.size());
		
		int found = 0;
		
		for(ImageEntity entity : expected){
			for(ImageEntity otherEntity : actual){
				if(entity.getId().equals(otherEntity.getId())){
					found++;
				}
			}
		}
		
		assertEquals(expected.size(), found);
	}
	
	@Test
	public void testMapEntitesToDto_Null() {
		assertNull(cut.mapEntitiesToDto(null));
	}
	
	@Test
	public void testMapDtosToEntity_NotNull(){
		List<ImageDTO> expected = ImageFactory.generateRandomImageDtos(RandomUtils.nextInt(0, 100));
		
		List<ImageEntity> result = cut.mapDtosToEntity(expected);
		
		List<ImageDTO> actual = cut.mapEntitiesToDto(result);
		
		assertEquals(expected.size(), actual.size());
		
		int found = 0;
		
		for(ImageDTO dto : expected){
			for(ImageDTO otherDto : actual){
				if(dto.getId().equals(otherDto.getId())){
					found++;
				}
			}
		}
		assertEquals(expected.size(), found);
	}
	
	@Test
	public void testMapDtosToEntity_Null() {
		assertNull(cut.mapDtosToEntity(null));
	}
}
