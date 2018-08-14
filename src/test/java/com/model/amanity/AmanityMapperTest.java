package com.model.amanity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.List;

import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

public class AmanityMapperTest {

	private AmanityMapper cut = new AmanityMapper();

	@Test
	public void testMapEntityToDto_NotNull() {
		AmanityEntity expected = AmanityFactory.generateRandomAmanityEntity();

		AmanityDTO result = cut.mapEntityToDto(expected);

		AmanityEntity actual = cut.mapDtoToEntity(result);

		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getName(), actual.getName());

	}

	@Test
	public void testMapEntityToDto_Null() {
		assertNull(cut.mapEntityToDto(null));
	}

	@Test
	public void testMapDtoToEntity_NotNull() {

		AmanityDTO expected = AmanityFactory.generateRandomAmanityDTO();

		AmanityEntity result = cut.mapDtoToEntity(expected);

		AmanityDTO actual = cut.mapEntityToDto(result);

		assertEquals(expected.getId(), actual.getId());
		assertEquals(expected.getName(), actual.getName());
	}

	@Test
	public void testMapDtoToEntity_Null() {
		assertNull(cut.mapDtoToEntity(null));
	}

	@Test
	public void testMapTypeEntityToDto_NotNull() {
		AmanityTypeEntity expected = AmanityFactory.generateRandomAmanityTypeEntity();

		AmanityTypeDTO result = cut.mapTypeEntityToDto(expected);

		AmanityTypeEntity actual = cut.mapTypeDtoToEntity(result);

		assertEquals(expected.name(), actual.name());
	}

	@Test
	public void testMapTypeEntityToDto_Null() {
		assertNull(cut.mapTypeEntityToDto(null));
	}

	@Test
	public void testMapTypeDtoToEntity_NotNull() {

		AmanityTypeDTO expected = AmanityFactory.generateRandomAmanityTypeDTO();

		AmanityTypeEntity result = cut.mapTypeDtoToEntity(expected);

		AmanityTypeDTO actual = cut.mapTypeEntityToDto(result);

		assertEquals(expected.name(), actual.name());
	}

	@Test
	public void testMapTypeDtoToEntity_Null() {
		assertNull(cut.mapTypeDtoToEntity(null));
	}

	@Test
	public void testMapEntitiesToDto_NotNull() {
		List<AmanityEntity> expected = AmanityFactory.generateRandomAmanityEntities(RandomUtils.nextInt(0, 100));

		List<AmanityDTO> result = cut.mapEntitiesToDto(expected);

		List<AmanityEntity> actual = cut.mapDtosToEntity(result);

		assertEquals(expected.size(), actual.size());

		int found = 0;

		for (AmanityEntity entity : expected) {
			for (AmanityEntity otherEntity : actual) {
				if (entity.getId().equals(otherEntity.getId())) {
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
	public void testMapDtosToEntity_NotNull() {
		List<AmanityDTO> expected = AmanityFactory.generateRandomAmanityDtos(RandomUtils.nextInt(0, 100));

		List<AmanityEntity> result = cut.mapDtosToEntity(expected);

		List<AmanityDTO> actual = cut.mapEntitiesToDto(result);

		assertEquals(expected.size(), actual.size());

		int found = 0;

		for (AmanityDTO dto : expected) {
			for (AmanityDTO otherDto : actual) {
				if (dto.getId().equals(otherDto.getId())) {
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
