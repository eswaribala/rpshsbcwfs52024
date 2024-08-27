import React from 'react';
import { shallow } from 'enzyme';
import HomeMenu from './HomeMenu';

describe('<HomeMenu />', () => {
  let component;

  beforeEach(() => {
    component = shallow(<HomeMenu />);
  });

  test('It should mount', () => {
    expect(component.length).toBe(1);
  });
});
