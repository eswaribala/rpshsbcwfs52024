import React from 'react';
import { shallow } from 'enzyme';
import Banner from './Banner';

describe('<Banner />', () => {
  let component;

  beforeEach(() => {
    component = shallow(<Banner />);
  });

  test('It should mount', () => {
    expect(component.length).toBe(1);
  });
});
